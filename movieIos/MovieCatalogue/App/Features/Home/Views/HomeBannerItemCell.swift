//
//  HomeBannerItemCell.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 26/09/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit
import Reusable
import KotlinCore
import SDWebImage

class HomeBannerItemCell: UICollectionViewCell, Reusable {

  lazy var imgBanner: UIImageView = {
    return UIImageView().apply {
      $0.contentMode = .scaleAspectFill
      $0.clipsToBounds = true
      $0.sd_imageIndicator = SDWebImageActivityIndicator.medium
    }
  }()

  var movie: Movie? {
    didSet {
      configureViews()
    }
  }

  private func configureViews() {

    imgBanner.sd_setImage(with: URL(string: Constants().urlImage + (movie?.backdropPath ?? "")))

    imgBanner.pin
      .height(frame.height)
      .width(frame.width)

    subviews(imgBanner)
  }

}
