//
//  HomeTabBarController.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 26/09/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit

class HomeTabBarController: UITabBarController {

  private let navigator: HomeNavigator

  init(navigator: HomeNavigator) {
    self.navigator = navigator
    super.init(nibName: nil, bundle: nil)
  }

  required init?(coder: NSCoder) {
    fatalError("init(coder:) has not been implemented")
  }

  override func viewDidLoad() {
    super.viewDidLoad()
    view.backgroundColor = .backgroundColor
    configureTabBar()
  }

  private func configureTabBar() {
    tabBar.isTranslucent = false
    tabBar.barTintColor = UIColor.primaryColor
    tabBar.tintColor = UIColor.accentColor
    tabBar.shadowImage = nil
    tabBar.layer.shadowColor = UIColor.primaryColor?.cgColor
    tabBar.layer.shadowOffset = CGSize(width: 0, height: 0)
    tabBar.layer.shadowRadius = 4
    tabBar.layer.shadowOpacity = 1

    delegate = self

    let homeTab = createTabController(vc: navigator.homeViewController, image: UIImage.iconHome!)
    let popularTab = createTabController(vc: navigator.searchViewController, image: UIImage.iconPopular!)
    let favoriteTab = createTabController(vc: navigator.favoriteViewController, image: UIImage.iconFavorite!)

    viewControllers = [homeTab, popularTab, favoriteTab]
  }

  private func createTabController(vc: UIViewController, image: UIImage) -> UINavigationController {
    let tabController = UINavigationController(rootViewController: vc)
    tabController.tabBarItem.image = image.withRenderingMode(.alwaysOriginal)
    tabController.tabBarItem.selectedImage = image.withRenderingMode(.alwaysTemplate)

    return tabController
  }
}

extension HomeTabBarController: UITabBarControllerDelegate {

  override func tabBar(_ tabBar: UITabBar, didSelect item: UITabBarItem) {}
}

