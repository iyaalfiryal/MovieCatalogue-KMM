//
//  UIView.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 27/09/21.
//  Copyright © 2021 Uwais Alqadri. All rights reserved.
//

import UIKit

extension UIView {
  func circle() {
    self.layer.cornerRadius = self.layer.bounds.size.width / 2
  }
}

extension UIView {

  @discardableResult
  func subviews(_ subViews: UIView...) -> UIView {
    subviews(subViews)
  }

  @discardableResult
  func subviews(@SubviewsBuilder content: () -> [UIView]) -> UIView {
    subviews(content())
  }

  @discardableResult
  func subviews(@SubviewsBuilder content: () -> UIView) -> UIView {
    let subview = content()
    subviews(subview)
    return self
  }

  @discardableResult
  @objc
  func subviews(_ subViews: [UIView]) -> UIView {
    for sv in subViews {
      addSubview(sv)
      sv.translatesAutoresizingMaskIntoConstraints = false
    }
    return self
  }
}

@_functionBuilder public struct SubviewsBuilder {
  public static func buildBlock(_ content: UIView...) -> [UIView] {
    return content
  }
}

