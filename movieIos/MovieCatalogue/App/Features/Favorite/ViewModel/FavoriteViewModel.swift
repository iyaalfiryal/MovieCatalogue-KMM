//
//  FavoriteViewModel.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 29/09/21.
//  Copyright © 2021 Uwais Alqadri. All rights reserved.
//

import Foundation
import KotlinCore
import RxSwift
import RxRelay
import KMPNativeCoroutinesRxSwift

class FavoriteViewModel {

  let favoriteMovies: BehaviorRelay<[Movie]> = .init(value: [Movie]())
  let favoriteState = PublishRelay<FavoriteState>()

  private let disposeBag = DisposeBag()
  private let favoriteUseCase: GetFavoriteMovieUseCase

  var query: String = ""

  enum FavoriteState {
    case favMovieFound(state: Bool)
    case addFavorite
    case removeFavorite
  }

  init(favoriteUseCase: GetFavoriteMovieUseCase) {
    self.favoriteUseCase = favoriteUseCase
    requestFavoriteMovie()
  }

  func requestFavoriteMovie() {
    createObservable(for: favoriteUseCase.getNative(query: query))
      .observe(on: MainScheduler.instance)
      .subscribe(onNext: { [weak self] result in
        self?.favoriteMovies.accept(result ?? [])
      }).disposed(by: disposeBag)
  }

  func checkFavoriteMovie(idMovie: Int) {
    createObservable(for: favoriteUseCase.getByIdNative(idMovie: Int32(idMovie)))
      .observe(on: MainScheduler.instance)
      .subscribe(onNext: { [weak self] result in
        result?.forEach { movie in
          self?.favoriteState.accept(.favMovieFound(state: movie.id as? Int ?? 0 == idMovie))
        }
      }).disposed(by: disposeBag)
  }

  func addFavoriteMovie(movie: Movie) {
    favoriteUseCase.add(movie: movie) { (_, _) in }
    favoriteState.accept(.addFavorite)
  }

  func removeFavoriteMovie(idMovie: Int) {
    favoriteUseCase.delete(idMovie: Int32(idMovie)) { (_, _) in }
    favoriteState.accept(.removeFavorite)
  }

}
