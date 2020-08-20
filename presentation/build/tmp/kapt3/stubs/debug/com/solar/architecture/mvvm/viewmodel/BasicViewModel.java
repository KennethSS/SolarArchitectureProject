package com.solar.architecture.mvvm.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/solar/architecture/mvvm/viewmodel/BasicViewModel;", "Lcom/solar/architecture/mvvm/viewmodel/BaseViewModel;", "foodRepository", "Lcom/solar/domain/repository/FoodRepository;", "(Lcom/solar/domain/repository/FoodRepository;)V", "_title", "Landroidx/lifecycle/MutableLiveData;", "", "get_title", "()Landroidx/lifecycle/MutableLiveData;", "_title$delegate", "Lkotlin/Lazy;", "title", "Landroidx/lifecycle/LiveData;", "getTitle", "()Landroidx/lifecycle/LiveData;", "getSample", "", "getSampleText", "app_debug"})
public final class BasicViewModel extends com.solar.architecture.mvvm.viewmodel.BaseViewModel {
    private final kotlin.Lazy _title$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> title = null;
    private final com.solar.domain.repository.FoodRepository foodRepository = null;
    
    private final androidx.lifecycle.MutableLiveData<java.lang.String> get_title() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getTitle() {
        return null;
    }
    
    public final void getSampleText() {
    }
    
    public final void getSample() {
    }
    
    public BasicViewModel(@org.jetbrains.annotations.NotNull()
    com.solar.domain.repository.FoodRepository foodRepository) {
        super();
    }
}