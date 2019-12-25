//
//  ViewController.swift
//  Lab 1
//
//  Created by Álvaro Santillan on 9/7/19.
//  Copyright © 2019 Álvaro Santillan. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var imageViewer: UIImageView!
    @IBOutlet weak var txtFeild: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }

    @IBAction func button1(_ sender: UIButton) {
        imageViewer.image = UIImage(named: "dankMeme1")
        txtFeild.text = "Meme 1 did load"
    }
    
    @IBAction func button2(_ sender: Any) {
        imageViewer.image = UIImage(named: "dankMeme2")
        txtFeild.text = "Meme 2 did load"
    }
    
    @IBAction func button3(_ sender: Any) {
        imageViewer.image = UIImage(named: "dankMeme3")
        txtFeild.text = "Meme 3 did load"
    }
}

