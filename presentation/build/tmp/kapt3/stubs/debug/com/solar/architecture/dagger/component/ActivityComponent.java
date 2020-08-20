package com.solar.architecture.dagger.component;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/solar/architecture/dagger/component/ActivityComponent;", "", "inject", "", "mainActivity", "Lcom/solar/architecture/MainActivity;", "mvvmActivity", "Lcom/solar/architecture/mvvm/view/MvvmActivity;", "app_debug"})
@dagger.Component(dependencies = {com.solar.architecture.dagger.component.AppComponent.class}, modules = {com.solar.architecture.dagger.module.RemoteModule.class, com.solar.architecture.dagger.module.DomainModule.class, com.solar.architecture.dagger.module.ActivityModule.class})
@com.solar.architecture.dagger.scope.ActivityScope()
public abstract interface ActivityComponent {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.solar.architecture.MainActivity mainActivity);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    com.solar.architecture.mvvm.view.MvvmActivity mvvmActivity);
}