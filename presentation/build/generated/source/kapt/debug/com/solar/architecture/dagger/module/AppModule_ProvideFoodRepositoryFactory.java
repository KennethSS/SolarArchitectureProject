// Generated by Dagger (https://dagger.dev).
package com.solar.architecture.dagger.module;

import com.solar.domain.repository.FoodRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideFoodRepositoryFactory implements Factory<FoodRepository> {
  private final AppModule module;

  private final Provider<FoodRepository> foodRepositoryProvider;

  public AppModule_ProvideFoodRepositoryFactory(AppModule module,
      Provider<FoodRepository> foodRepositoryProvider) {
    this.module = module;
    this.foodRepositoryProvider = foodRepositoryProvider;
  }

  @Override
  public FoodRepository get() {
    return provideFoodRepository(module, foodRepositoryProvider.get());
  }

  public static AppModule_ProvideFoodRepositoryFactory create(AppModule module,
      Provider<FoodRepository> foodRepositoryProvider) {
    return new AppModule_ProvideFoodRepositoryFactory(module, foodRepositoryProvider);
  }

  public static FoodRepository provideFoodRepository(AppModule instance,
      FoodRepository foodRepository) {
    return Preconditions.checkNotNull(instance.provideFoodRepository(foodRepository), "Cannot return null from a non-@Nullable @Provides method");
  }
}