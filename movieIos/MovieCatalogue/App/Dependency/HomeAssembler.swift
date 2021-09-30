//
//  HomeAssembler.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 24/09/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import KotlinCore

protocol HomeAssembler {
  func resolve() -> HomeNavigator
  func resolve() -> HomeTabBarController
  func resolve() -> HomeViewController
  func resolve() -> HomeViewModel

  func resolve() -> GetBannerMovieUseCase
  func resolve() -> GetPopularMovieUseCase
  func resolve() -> GetUpComingMovieUseCase

}

extension HomeAssembler where Self: Assembler {
  func resolve() -> HomeTabBarController {
    return HomeTabBarController(navigator: resolve())
  }

  func resolve() -> HomeViewController {
    return HomeViewController(navigator: resolve(), viewModel: resolve())
  }

  func resolve() -> HomeNavigator {
    return DefaultHomeNavigator(assembler: self)
  }

  func resolve() -> HomeViewModel {
    return HomeViewModel(popularUseCase: resolve(), upComingUseCase: resolve(), bannerUseCase: resolve())
  }

  func resolve() -> GetBannerMovieUseCase {
    return GetBannerMovieInteractor(repository: resolve())
  }

  func resolve() -> GetPopularMovieUseCase {
    return GetPopularMovieInteractor(repository: resolve())
  }

  func resolve() -> GetUpComingMovieUseCase {
    return GetUpComingMovieInteractor(repository: resolve())
  }

}
