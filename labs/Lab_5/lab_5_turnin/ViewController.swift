//
//  ViewController.swift
//  lab_5_turnin
//
//  Created by Álvaro Santillan on 10/21/19.
//  Copyright © 2019 Álvaro Santillan. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var nameDisplay: UILabel!
    @IBOutlet weak var favColorDisplay: UILabel!
    @IBOutlet weak var favNumberDisplay: UILabel!
    @IBOutlet weak var petPrefCat: UILabel!
    @IBOutlet weak var petPrefDog: UILabel!
    
    var user = userInfo()
    
    @IBAction func unwindSegue (_ segue:UIStoryboardSegue){
        let name = "Hello " + user.firstName! + " " + user.lastName!
        let color = user.favColor! + " is a great color."
        
        nameDisplay.text = name
        favColorDisplay.text = color
        favNumberDisplay.text = user.favNumber
        print(user.catPerson)
        print(user.dogPerson)
        
//        if user.dogPerson == true {
//            petPrefCat.text = "true"
//
//        }
//        else if user.dogPerson == false {
//            petPrefCat.text = "false"
//        }
        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

