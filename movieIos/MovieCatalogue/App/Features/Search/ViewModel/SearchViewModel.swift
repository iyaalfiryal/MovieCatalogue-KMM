//
//  SearchViewModel.swift
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

class SearchViewModel {

  let searchMovies: BehaviorRelay<[Movie]> = .init(value: [Movie]())

  private let disposeBag = DisposeBag()
  private let searchUseCase: GetSearchMovieUseCase

  var query: String?

  init(searchUseCase: GetSearchMovieUseCase) {
    self.searchUseCase = searchUseCase
  }

  func requestSearch() {

    guard let query = query else { return }

    createObservable(for: searchUseCase.executeNative(query: query, page: 1))
      .observe(on: MainScheduler.instance)
      .subscribe(onNext: { [weak self] result in
        self?.searchMovies.accept(result)
      }).disposed(by: disposeBag)
  }
}

