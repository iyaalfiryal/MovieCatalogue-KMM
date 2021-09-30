//
//  AppDelegate.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 24/09/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit
import KotlinCore

@main
class AppDelegate: UIResponder, UIApplicationDelegate {

  var window: UIWindow?
  private let assembler = AppAssembler()

  func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {

    window = UIWindow(frame: UIScreen.main.bounds)
    CoreKt.doInitKoin()

    let navigator: HomeNavigator = assembler.resolve()
    navigator.navigateToHome(window: window)
    window?.makeKeyAndVisible()

    return true
  }
}
