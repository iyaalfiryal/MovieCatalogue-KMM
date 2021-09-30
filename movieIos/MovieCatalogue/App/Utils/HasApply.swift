//
//  HasApply.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 27/09/21.
//  Copyright © 2021 Uwais Alqadri. All rights reserved.
//

import Foundation

protocol Utils: class {}

extension NSObject: Utils {}

extension Utils {

  // kotlin-like scope operator
  func apply(closure:(Self) -> ()) -> Self {
    closure(self)
    return self
  }

  // guard let self = self else { return } in fancy way
  func weakify<T>(_ code: @escaping (Self, T) -> Void) -> (T) -> Void {
    return { [weak self] (data) in
      guard let self = self else { return }
      code(self, data)
    }
  }

}
