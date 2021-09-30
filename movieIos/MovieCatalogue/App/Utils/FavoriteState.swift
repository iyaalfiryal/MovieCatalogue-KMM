//
//  FavoriteState.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 30/09/21.
//  Copyright © 2021 Uwais Alqadri. All rights reserved.
//

import Foundation
import KotlinCore

enum FavoriteState {
  case favMovieFound(movies: [Movie])
  case addFavorite
  case removeFavorite
}
