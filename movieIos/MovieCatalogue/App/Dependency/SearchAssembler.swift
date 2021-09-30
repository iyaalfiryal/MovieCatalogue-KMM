//
//  SearchAssembler.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 24/09/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import KotlinCore

protocol SearchAssembler {
  func resolve() -> SearchViewController
  func resolve() -> SearchNavigator

  func resolve() -> SearchViewModel
  func resolve() -> GetSearchMovieUseCase
}

extension SearchAssembler where Self: Assembler {
  func resolve() -> SearchNavigator {
    return DefaultPopularNavigator(assembler: self)
  }

  func resolve() -> SearchViewController {
    return SearchViewController(navigator: resolve(), viewModel: resolve())
  }

  func resolve() -> SearchViewModel {
    return SearchViewModel(searchUseCase: resolve())
  }

  func resolve() -> GetSearchMovieUseCase {
    return GetSearchMovieInteractor(repository: resolve())
  }

}
