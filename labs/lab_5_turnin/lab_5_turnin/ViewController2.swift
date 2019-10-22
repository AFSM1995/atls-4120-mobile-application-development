//
//  ViewController2.swift
//  lab_5_turnin
//
//  Created by Álvaro Santillan on 10/21/19.
//  Copyright © 2019 Álvaro Santillan. All rights reserved.
//

import UIKit

class ViewController2: UIViewController {
    var dogString = String()
    var dogPerson = Bool()
    var catPerson = Bool()
    
    @IBOutlet weak var firstName: UITextField!
    @IBOutlet weak var lastName: UITextField!
    @IBOutlet weak var favColor: UITextField!
    @IBOutlet weak var favNumber: UITextField!
    
    
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        //if segue.identifier == "doneFavs"{
        let scene1ViewController = segue.destination as! ViewController
        //check to see that text was entered in the textfields
        if firstName.text!.isEmpty == false{
            scene1ViewController.user.firstName = firstName.text
        }
        if lastName.text!.isEmpty == false{
            scene1ViewController.user.lastName = lastName.text
        }
        if favColor.text!.isEmpty == false{
            scene1ViewController.user.favColor = favColor.text
        }
        if favNumber.text!.isEmpty == false{
            scene1ViewController.user.favNumber = favNumber.text
        }
//        if dogPerson == true{
//            scene1ViewController.petPrefDog.text = firstName.text! + " is a dog person"
//        }
//        else if dogPerson == false{
//            scene1ViewController.petPrefDog.text = firstName.text! + " is not a dog person"
//        }
//        if catPerson == true{
//            scene1ViewController.petPrefCat.text = firstName.text! + " is a cat person"
//        }
//        else if catPerson == false{
//            scene1ViewController.petPrefCat.text = firstName.text! + " is not a cat person"
//        }
        //}
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()

        print("current state cat:", catPerson)
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
