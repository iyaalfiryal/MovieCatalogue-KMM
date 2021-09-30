//
//  HomeNavigator.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 24/09/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit

protocol HomeNavigator {
  func navigateToHome(window: UIWindow?)
  func navigateToDetail(from viewController: UIViewController, with id: Int)

  var homeViewController: HomeViewController { get }
  var searchViewController: SearchViewController { get }
  var favoriteViewController: FavoriteViewController { get }
}

struct DefaultHomeNavigator: HomeNavigator {

  private let assembler: Assembler

  init(assembler: Assembler) {
    self.assembler = assembler
  }

  func navigateToHome(window: UIWindow?) {
    let homeTabBar: HomeTabBarController = assembler.resolve()
    window?.rootViewController = homeTabBar
  }

  func navigateToDetail(from viewController: UIViewController, with id: Int) {
    let navigator: DetailNavigator = assembler.resolve()
    navigator.navigateToDetail(from: viewController, with: id)
  }

  var homeViewController: HomeViewController {
    assembler.resolve()
  }

  var searchViewController: SearchViewController {
    assembler.resolve()
  }

  var favoriteViewController: FavoriteViewController {
    assembler.resolve()
  }
}
