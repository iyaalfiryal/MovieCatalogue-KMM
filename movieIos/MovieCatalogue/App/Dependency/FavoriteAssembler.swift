//
//  FavoriteAssembler.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 24/09/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit
import KotlinCore

protocol FavoriteAssembler {
  func resolve() -> FavoriteNavigator
  func resolve() -> FavoriteViewController

  func resolve() -> FavoriteViewModel
  func resolve() -> GetFavoriteMovieUseCase
}

extension FavoriteAssembler where Self: Assembler {

  func resolve() -> GetFavoriteMovieUseCase {
    return GetFavoriteMovieInteractor(repository: resolve())
  }

  func resolve() -> FavoriteViewModel {
    return FavoriteViewModel(favoriteUseCase: resolve())
  }

  func resolve() -> FavoriteNavigator {
    return DefaultFavoriteNavigator(assembler: self)
  }

  func resolve() -> FavoriteViewController {
    return FavoriteViewController(navigator: resolve(), viewModel: resolve())
  }
}

