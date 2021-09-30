//
//  SearchNavigator.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 26/09/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit

protocol SearchNavigator {
  func navigateToDetail(from viewController: UIViewController, with id: Int)
}

struct DefaultPopularNavigator: SearchNavigator {

  private let assembler: Assembler

  init(assembler: Assembler) {
    self.assembler = assembler
  }

  func navigateToDetail(from viewController: UIViewController, with id: Int) {
    let navigator: DetailNavigator = assembler.resolve()
    navigator.navigateToDetail(from: viewController, with: id)
  }
}
