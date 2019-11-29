//
//  ViewController2.swift
//  lab_5_turnin
//
//  Created by Álvaro Santillan on 10/21/19.
//  Copyright © 2019 Álvaro Santillan. All rights reserved.
//

import UIKit

class ViewController2: UIViewController, UITextFieldDelegate {
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
        if dogPerson == true{
            scene1ViewController.petPrefDog.text = firstName.text! + " is a dog person"
            scene1ViewController.user.dogPerson = true
        }
        else if dogPerson == false{
            scene1ViewController.petPrefDog.text = firstName.text! + " is not a dog person"
            scene1ViewController.user.dogPerson = false
        }
        if catPerson == true{
            scene1ViewController.petPrefCat.text = firstName.text! + " is a cat person"
            scene1ViewController.user.catPerson = true
        }
        else if catPerson == false{
            scene1ViewController.petPrefCat.text = firstName.text! + " is not a cat person"
            scene1ViewController.user.catPerson = false
        }
        //}
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        firstName.delegate = self
        lastName.delegate = self
        favNumber.delegate = self
        favNumber.keyboardType = .numberPad
        favColor.delegate = self
        print("current state cat:", catPerson)
        // Do any additional setup after loading the view.
    }
    
    // Hide keyboard when the user press return
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    // Hide keyboard when user touches outside keyboard.
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
}
