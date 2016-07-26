package com.mysite.selenium.Runner;

import com.mysite.selenium.HomePageBing;
import com.mysite.selenium.HomePageGoogle;
import com.mysite.selenium.Interceptor.Interceptor;
import com.mysite.selenium.Interceptor.InterceptorRunner;
import com.mysite.selenium.Tests.TestBase;
import com.mysite.selenium.Tests.TestSearch;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.runners.Suite.*;

@RunWith(Suite.class)
@SuiteClasses({Runner.RunChrome.class, Runner.RunFirefox.class})
public class Runner extends TestBase {

    //region Chrome
    @RunWith(Suite.class)
    @SuiteClasses({RunChrome.RunGoogle.class, RunChrome.RunBing.class})
    public static class RunChrome {

        public static void InitializeBrowser() {
            driver = new ChromeDriver();
            driverWait = new WebDriverWait(driver, 5);
        }
        //region Google
        @RunWith(Suite.class)
        @SuiteClasses({RunGoogle.RunTestSearch.class})
        public static class RunGoogle {

            public static void InitializeSite() {
                InitializeBrowser();
                driver.get(HomePageGoogle.URL_HOMEPAGE);
            }

            @RunWith(InterceptorRunner.class)
            @SuiteClasses({TestSearch.class})
            @InterceptorRunner.InterceptorClasses({RunTestSearch.Interceptor1.class})
            public static class RunTestSearch extends TestSearch {

                public static class Interceptor1 implements Interceptor {
                    @Override
                    public void interceptBefore() {
                        InitializeSite();
                        initializeGooglePage();
                    }

                    @Override
                    public void interceptAfter() {
                        driver.close();

                    }
                }
            }
        }
        //endregion
        //region Bing
        @RunWith(Suite.class)
        @SuiteClasses({RunBing.RunTestSearch.class})
        public static class RunBing {

            public static void InitializeSite() {
                InitializeBrowser();
                driver.get(HomePageBing.URL_HOMEPAGE);
            }

            @RunWith(InterceptorRunner.class)
            @SuiteClasses({TestSearch.class})
            @InterceptorRunner.InterceptorClasses({RunTestSearch.Interceptor1.class})
            public static class RunTestSearch extends TestSearch {

                public static class Interceptor1 implements Interceptor {
                    @Override
                    public void interceptBefore() {
                        InitializeSite();
                        initializeBingPage();
                    }

                    @Override
                    public void interceptAfter() {
                        driver.close();

                    }
                }
            }
        }
        //endregion
    }
    //endregion

    //region Firefox
    @RunWith(Suite.class)
    @SuiteClasses({RunFirefox.RunGoogle.class, RunFirefox.RunBing.class})
    public static class RunFirefox {

        public static void InitializeBrowser() {
            driver = new FirefoxDriver();
            driverWait = new WebDriverWait(driver, 5);
        }
        //region Google
        @RunWith(Suite.class)
        @SuiteClasses({RunGoogle.RunTestSearch.class})
        public static class RunGoogle {

            public static void InitializeSite() {
                InitializeBrowser();
                driver.get(HomePageGoogle.URL_HOMEPAGE);
            }

            @RunWith(InterceptorRunner.class)
            @SuiteClasses({TestSearch.class})
            @InterceptorRunner.InterceptorClasses({RunTestSearch.Interceptor1.class})
            public static class RunTestSearch extends TestSearch {

                public static class Interceptor1 implements Interceptor {
                    @Override
                    public void interceptBefore() {
                        InitializeSite();
                        initializeGooglePage();
                    }

                    @Override
                    public void interceptAfter() {
                        driver.close();

                    }
                }
            }
        }
        //endregion
        //region Bing
        @RunWith(Suite.class)
        @SuiteClasses({RunBing.RunTestSearch.class})
        public static class RunBing {

            public static void InitializeSite() {
                InitializeBrowser();
                driver.get(HomePageBing.URL_HOMEPAGE);
            }

            @RunWith(InterceptorRunner.class)
            @SuiteClasses({TestSearch.class})
            @InterceptorRunner.InterceptorClasses({RunTestSearch.Interceptor1.class})
            public static class RunTestSearch extends TestSearch {

                public static class Interceptor1 implements Interceptor {
                    @Override
                    public void interceptBefore() {
                        InitializeSite();
                        initializeBingPage();
                    }

                    @Override
                    public void interceptAfter() {
                        driver.close();

                    }
                }
            }
        }
        //endregion
    }
    //endregion
}
