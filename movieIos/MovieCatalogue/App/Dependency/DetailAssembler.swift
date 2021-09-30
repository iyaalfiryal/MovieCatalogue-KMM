//
//  DetailAssembler.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 24/09/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import KotlinCore

protocol DetailAssembler {
  func resolve(with id: Int) -> DetailViewController
  func resolve() -> DetailNavigator

  func resolve(with id: Int) -> DetailViewModel
  func resolve() -> GetDetailMovieUseCase
  func resolve() -> GetVideoMovieUseCase
  func resolve() -> GetCastMovieUseCase
}

extension DetailAssembler where Self: Assembler {

  func resolve() -> GetDetailMovieUseCase {
    return GetDetailMovieInteractor(repository: resolve())
  }

  func resolve() -> GetVideoMovieUseCase {
    return GetVideoMovieInteractor(repository: resolve())
  }

  func resolve() -> GetCastMovieUseCase {
    return GetCastMovieInteractor(repository: resolve())
  }

  func resolve(with id: Int) -> DetailViewModel {
    return DetailViewModel(detailUseCase: resolve(), castUseCase: resolve(), videoUseCase: resolve(), favoriteUseCase: resolve(), idMovie: id)
  }

  func resolve(with id: Int) -> DetailViewController {
    return DetailViewController(navigator: resolve(), viewModel: resolve(with: id), favoriteViewModel: resolve())
  }

  func resolve() -> DetailNavigator {
    return DefaultDetailNavigator(assembler: self)
  }
}
