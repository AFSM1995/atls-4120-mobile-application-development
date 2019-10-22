//
//  ViewControllerDog.swift
//  lab_5_turnin
//
//  Created by Álvaro Santillan on 10/21/19.
//  Copyright © 2019 Álvaro Santillan. All rights reserved.
//

import UIKit

var user = userInfo()

class ViewControllerDog: UIViewController {
    @IBOutlet weak var dogPersonSeg: UISegmentedControl!
    
//    @IBAction func button(_ sender: UIButton) {
//            performSegue(withIdentifier: "dogToCat", sender: self)
//    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let viewControllerCat = segue.destination as! ViewControllerCat
        
        if dogPersonSeg.selectedSegmentIndex == 0 {
            viewControllerCat.dogString = "Ok cool you a dog person."
            viewControllerCat.dogPerson = true
        }
        else if dogPersonSeg.selectedSegmentIndex == 1 {
            viewControllerCat.dogString = "Werid, your not a dog person."
            viewControllerCat.dogPerson = false
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view.
    }
}
