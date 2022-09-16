package ui_tests.base;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryOnFail implements IRetryAnalyzer {
    private int actualRetry = 0;
    private static final int MAX_RETRY = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (actualRetry < MAX_RETRY) {
            actualRetry++;
            return true;
        } else {
            return false;
        }
    }
}
