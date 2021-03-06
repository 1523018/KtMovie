package com.jackson.ktmovie.dagger.module

import com.jackson.ktmovie.apiservice.JsNetworkService
import com.jackson.ktmovie.apiservice.RetrofitClient
import com.jackson.ktmovie.model.HotShowModel
import com.jackson.ktmovie.model.IModel
import com.jackson.ktmovie.presenter.HotShowPresenter
import com.jackson.ktmovie.utils.Constant
import com.jackson.ktmovie.view.IView
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * InTheatersModule  2018-07-02
 * Copyright (c) 2018 JS Co.Ltd. All right reserved.
 */
/**
 * class description here
 * @author Jackson
 * @version 1.0.0
 * since 2018 07 02
 */
@Module
class HotShowModule {

    private lateinit var hotShowView: IView.IHotShowView

    /**
     * 空的构造方法，在presenter使用
     */
    constructor() {

    }

    /**
     * 在Fragment使用
     */
    constructor(view: IView.IHotShowView) {
        this.hotShowView = view
    }


    /**
     * 提供Presenter，正在上映
     */
    @Provides
    @Singleton
    fun provideHotShowPresenter(iIHotShowView: IView.IHotShowView): HotShowPresenter =
            HotShowPresenter(iIHotShowView)

    /**
     * 提供HotShowModel
     */
    @Provides
    @Singleton
    fun provideHotShowModel(mJsNetworkService: JsNetworkService): IModel.IHotShowModel =
            HotShowModel(mJsNetworkService)


    /**
     * JsNetworkService
     */
    @Provides
    @Singleton
    fun provideJsNetworkService(retrofitClient: RetrofitClient) =
            JsNetworkService(retrofitClient)

    /**
     * JsNetworkService
     */
    @Provides
    @Singleton
    fun provideRetrofitClient() =
            RetrofitClient(Constant.baseUrl)

    /**
     * IHotShowView
     */
    @Provides
    @Singleton
    fun provideIHotShowView(): IView.IHotShowView =
            hotShowView


}