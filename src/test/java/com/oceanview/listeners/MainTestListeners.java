package com.oceanview.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MainTestListeners implements ITestListener {

    static ExtentReports extent;
    static ExtentTest extentTest;
    static ExtentSparkReporter spark;

    public void onTestStart(ITestResult result) {
        extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        ExtentTest node = extentTest.createNode("TEST :" +result.getName());
        node.pass("PASS");
        extentTest.log(Status.PASS, "TEST PASSED");

    }
    public void onTestFailure(ITestResult result) {
        Throwable throwvar = new Throwable();
        extentTest.log(Status.FAIL, "TEST FAILED: " +throwvar.getMessage());


    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("./reports/Report_"+System.currentTimeMillis()+".html");
        extent.attachReporter(spark);
        System.out.println("TEST CONTEXT: "+context.getName());
    }



    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
