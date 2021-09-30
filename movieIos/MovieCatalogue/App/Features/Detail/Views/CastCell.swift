//
//  CastCell.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 24/09/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit
import Reusable
import PinLayout
import KotlinCore
import SDWebImage

class CastCell: UICollectionViewCell, Reusable {

  lazy var imgCast: UIImageView = {
    return UIImageView().apply { (img) in
      img.contentMode = .scaleAspectFill
      img.layer.masksToBounds = false
      img.clipsToBounds = true
    }
  }()

  lazy var lblCast: UILabel = {
    return UILabel().apply { (lbl) in
      lbl.font = .systemFont(ofSize: 12)
      lbl.textColor = .white
      lbl.numberOfLines = 2
      lbl.textAlignment = .center
    }
  }()

  var cast: Cast? {
    didSet {
      configureViews()
    }
  }

  private func configureViews() {

    subviews {
      imgCast
      lblCast
    }

    imgCast.circle()
    imgCast.sd_setImage(with: URL(string: Constants().urlImage + (cast?.profilePath ?? "")))
    lblCast.text = cast?.name

    contentView.pin.all()

    imgCast.pin
      .top()
      .horizontally()
      .size(.init(width: 95, height: 95))

    lblCast.pin
      .below(of: imgCast)
      .horizontally()
      .bottom()
  }

  override func layoutSubviews() {
    configureViews()
  }
}
