//
//  ViewControllerCat.swift
//  lab_5_turnin
//
//  Created by Álvaro Santillan on 10/21/19.
//  Copyright © 2019 Álvaro Santillan. All rights reserved.
//

import UIKit

class ViewControllerCat: UIViewController {
    @IBOutlet weak var label: UILabel!
    @IBOutlet weak var catPersonSeg: UISegmentedControl!
    
    var dogString = String()
    var dogPerson = Bool()
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        let viewController2 = segue.destination as! ViewController2
        
        if catPersonSeg.selectedSegmentIndex == 0 {
            viewController2.catPerson = true
            viewController2.dogPerson = dogPerson
        }
        else if catPersonSeg.selectedSegmentIndex == 1 {
            viewController2.catPerson = false
            viewController2.dogPerson = dogPerson
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        label.text = dogString
        print("current state:", dogPerson)
        // Do any additional setup after loading the view.
    }
    
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
