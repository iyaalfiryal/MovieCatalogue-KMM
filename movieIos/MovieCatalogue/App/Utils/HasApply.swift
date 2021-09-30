//
//  HasApply.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 27/09/21.
//  Copyright © 2021 Uwais Alqadri. All rights reserved.
//

import Foundation

protocol HasApply: class {}

extension NSObject: HasApply {}

extension HasApply {

  // kotlin-like scope operator
  func apply(closure:(Self) -> ()) -> Self {
    closure(self)
    return self
  }
}
