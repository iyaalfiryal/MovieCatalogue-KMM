//
//  DetailViewModel.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 27/09/21.
//  Copyright © 2021 Uwais Alqadri. All rights reserved.
//

import Foundation
import RxSwift
import RxRelay
import KotlinCore
import KMPNativeCoroutinesRxSwift

class DetailViewModel {

  let detailMovie = PublishRelay<Movie>()
  let castMovie = BehaviorRelay<[Cast]>(value: [Cast]())
  let videoMovie = BehaviorRelay<[Video]>(value: [Video]())

  private let disposeBag = DisposeBag()
  private let detailUseCase: GetDetailMovieUseCase
  private let castUseCase: GetCastMovieUseCase
  private let videoUseCase: GetVideoMovieUseCase
  private let idMovie: Int

  init(detailUseCase: GetDetailMovieUseCase, castUseCase: GetCastMovieUseCase, videoUseCase: GetVideoMovieUseCase, idMovie: Int) {
    self.detailUseCase = detailUseCase
    self.castUseCase = castUseCase
    self.videoUseCase = videoUseCase
    self.idMovie = idMovie
  }

  func requestDetailMovie() {
    createObservable(for: detailUseCase.executeNative(idMovie: Int32(idMovie)))
      .observe(on: MainScheduler.instance)
      .subscribe(onNext: { [weak self] result in
        self?.detailMovie.accept(result)
      }).disposed(by: disposeBag)
  }

  func requestCastMovie() {
    createObservable(for: castUseCase.executeNative(idMovie: Int32(idMovie)))
      .observe(on: MainScheduler.instance)
      .subscribe(onNext: { [weak self] result in
        self?.castMovie.accept(result)
      }).disposed(by: disposeBag)
  }

  func requestVideoMovie() {
    createObservable(for: videoUseCase.executeNative(idMovie: Int32(idMovie)))
      .observe(on: MainScheduler.instance)
      .subscribe(onNext: { [weak self] result in
        self?.videoMovie.accept(result)
      }).disposed(by: disposeBag)
  }
}
