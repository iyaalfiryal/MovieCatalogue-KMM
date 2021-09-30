//
//  AppAssembler.swift
//  MovieCatalogue
//
//  Created by Uwais Alqadri on 24/09/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation

protocol Assembler: HomeAssembler,
                    DetailAssembler,
                    FavoriteAssembler,
                    SearchAssembler,
                    KotlinCoreAssembler {}

class AppAssembler: Assembler {}
