/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package empolyesecurity.testtaskmvp.di.component;


import dagger.Component;
import empolyesecurity.testtaskmvp.di.PerActivity;
import empolyesecurity.testtaskmvp.di.module.ActivityModule;
import empolyesecurity.testtaskmvp.ui.blogs.BlogActivity;
import empolyesecurity.testtaskmvp.ui.login.LoginActivity;
import empolyesecurity.testtaskmvp.ui.splash.SplashActivity;


/**
 * Created by janisharali on 27/01/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(SplashActivity activity);
    void inject(LoginActivity activity);
    //void inject(FeedActivity activity);
    //void inject(OpenSourceFragment fragment);

    void inject(BlogActivity fragment);
   // void inject(MainActivity activity);

   /* void inject(MainActivity activity);

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(FeedActivity activity);

    void inject(AboutFragment fragment);

    void inject(OpenSourceFragment fragment);

    void inject(BlogActivity fragment);

    void inject(RateUsDialog dialog);*/

}
