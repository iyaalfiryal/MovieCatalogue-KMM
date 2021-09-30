//
//  HomeItemCell.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 24/09/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit
import Reusable
import KotlinCore
import SDWebImage

class HomeItemCell: UICollectionViewCell, Reusable {

  lazy var imgPoster: UIImageView = {
    return UIImageView().apply { img in
      img.contentMode = .scaleAspectFit
      img.sd_imageIndicator = SDWebImageActivityIndicator.medium
    }
  }()

  var movie: Movie? {
    didSet {
      configureViews()
    }
  }

  func configureViews() {
    imgPoster.sd_setImage(with: URL(string: Constants().urlImage + (movie?.posterPath ?? "")))

    subviews(imgPoster)

    imgPoster.pin
      .height(frame.height)
      .width(102)
  }

}
