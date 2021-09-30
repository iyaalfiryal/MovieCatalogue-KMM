//
//  DetailNavigator.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 26/09/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit

protocol DetailNavigator {
  func navigateToDetail(from viewController: UIViewController?, with id: Int)
}

struct DefaultDetailNavigator: DetailNavigator {

  private let assembler: Assembler

  init(assembler: Assembler) {
    self.assembler = assembler
  }

  func navigateToDetail(from viewController: UIViewController?, with id: Int) {
    let nextViewController = DetailViewController(navigator: assembler.resolve(), viewModel: assembler.resolve(with: id), favoriteViewModel: assembler.resolve())
    nextViewController.hidesBottomBarWhenPushed = true
    viewController?.navigationController?.pushViewController(nextViewController, animated: true)
  }
}
