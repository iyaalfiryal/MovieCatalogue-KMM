//
//  PaddedLabel.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 26/09/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import UIKit

class PaddedLabel: UILabel {
  var insets = UIEdgeInsets.zero

  func padding(top: CGFloat, bottom: CGFloat, left: CGFloat, right: CGFloat) {
    self.frame = CGRect(x: 0, y: 0, width: self.frame.width + left + right, height: self.frame.height + top + bottom)
    insets = UIEdgeInsets(top: top, left: left, bottom: bottom, right: right)
  }

  override func drawText(in rect: CGRect) {
    super.drawText(in: rect.inset(by: insets))
    clipsToBounds = true
  }

  override var intrinsicContentSize: CGSize {
    get {
      var contentSize = super.intrinsicContentSize
      contentSize.height += insets.top + insets.bottom
      contentSize.width += insets.left + insets.right
      return contentSize
    }
  }
}
