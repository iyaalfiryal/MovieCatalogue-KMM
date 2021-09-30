//
//  HomeViewModel.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 26/09/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import RxSwift
import RxRelay
import KotlinCore
import KMPNativeCoroutinesRxSwift

class HomeViewModel {

  let popularMovies: BehaviorRelay<[Movie]> = .init(value: [Movie]())
  let upComingMovies: BehaviorRelay<[Movie]> = .init(value: [Movie]())
  let bannerMovies: BehaviorRelay<[Movie]> = .init(value: [Movie]())

  private let disposeBag = DisposeBag()
  private let popularUseCase: GetPopularMovieUseCase
  private let upComingUseCase: GetUpComingMovieUseCase
  private let bannerUseCase: GetBannerMovieUseCase

  init(popularUseCase: GetPopularMovieUseCase, upComingUseCase: GetUpComingMovieUseCase, bannerUseCase: GetBannerMovieUseCase) {
    self.popularUseCase = popularUseCase
    self.upComingUseCase = upComingUseCase
    self.bannerUseCase = bannerUseCase
  }

  func requestPopularMovie() {
    createObservable(for: popularUseCase.executeNative(year: Extensions().currentYear, page: 1, sortBy: .popularity))
      .observe(on: MainScheduler.instance)
      .subscribe(onNext: { [weak self] result in
        self?.popularMovies.accept(Array(result[0...9]))
      }).disposed(by: disposeBag)
  }

  func requestUpComingMovie() {
    createObservable(for: upComingUseCase.executeNative(year: Extensions().nextYear, page: 1, sortBy: .popularity))
      .observe(on: MainScheduler.instance)
      .subscribe(onNext: { [weak self] result in
        self?.upComingMovies.accept(Array(result[0...9]))
      }).disposed(by: disposeBag)
  }

  func requestBannerMovie() {
    createObservable(for: bannerUseCase.executeNative(year: Extensions().currentYear, page: 1, sortBy: .release_))
      .observe(on: MainScheduler.instance)
      .subscribe(onNext: { [weak self] result in
        self?.bannerMovies.accept(Array(result[0...2]))
      }).disposed(by: disposeBag)
  }
}
