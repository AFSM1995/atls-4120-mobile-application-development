//
//  ViewController.swift
//  Lab 4
//
//  Created by Álvaro Santillan on 10/1/19.
//  Copyright © 2019 Álvaro Santillan. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var leftText: UITextField!
    @IBOutlet weak var rightText: UITextField!
    @IBOutlet weak var stepperLeft: UIStepper!
    @IBOutlet weak var stepperRight: UIStepper!
    @IBOutlet weak var result: UILabel!
    
    // Hide keyboard when the user press return
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        // Display message
        let alert3=UIAlertController(title: "Did you know?", message: "Apple invested 1.4 million in making auto-layout evil. Rather, yes, it was created with the sole purpose to toucher students.", preferredStyle: UIAlertController.Style.alert)
        let cancelAction3=UIAlertAction(title: "Sure", style:UIAlertAction.Style.cancel, handler: nil)
        alert3.addAction(cancelAction3)
        present(alert3, animated: true, completion: nil)
        return true
    }
    
    // Hide keyboard when user touches outside keyboard.
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
        // Display message
        let alert4=UIAlertController(title: "Did you know?", message: "Apple dose does not sell apples. Truly a missed opportunity. $125 dollar apples are quite profitable.", preferredStyle: UIAlertController.Style.alert)
        let cancelAction4=UIAlertAction(title: "Agreeded I would buy one.", style:UIAlertAction.Style.cancel, handler: nil)
        alert4.addAction(cancelAction4)
        present(alert4, animated: true, completion: nil)
    }
    
    // Update left text feild to always have a number.
    @IBAction func updateLeft(_ sender: UIStepper) {
        if stepperLeft.value == 0 {
            leftText.text = "0"
        } else {
            leftText.text = String(stepperLeft.value)
        }
        updateResult()
    }
    
    // Update left text feild to always have a number.
    @IBAction func updateRight(_ sender: UIStepper) {
        if stepperRight.value == 0 {
            rightText.text = "0"
        } else {
            rightText.text = String(stepperRight.value)
        }
            updateResult()
    }
    
    // Check if value in numerical
    // 2 lines "with a little help from my friends" - famous band
    // https://rosettacode.org/wiki/Determine_if_a_string_is_numeric#Swift
    func isNumeric(testSubject: String) -> Bool {
        return Double(testSubject) != nil
    }
    
    // Heart of the operation
    func updateResult() {
        var displayResult:Float
        var leftInput:Float
        var rightInput:Float
        
        let leftCheck = isNumeric(testSubject: leftText.text!)
        let rightCheck = isNumeric(testSubject: rightText.text!)
        
        // Check if illigal value
        if leftCheck == false{
            print("consile left Na Fam")
            let alert=UIAlertController(title: "Naa Fam", message: "Take your letters and fancy algebra out of the left input. Or give me numbers XOXO.", preferredStyle: UIAlertController.Style.alert)
            let cancelAction=UIAlertAction(title: "Got it fam", style:UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancelAction)
            leftInput = 0.0
            
            present(alert, animated: true, completion: nil)
        } else{
            leftInput = Float(leftText.text!)!
        }
        
        // Check if illigal value
        if rightCheck == false{
            print("Conslie right Na Fam")
            let alert2=UIAlertController(title: "Naa Fam", message: "Take your letters and fancy algebra out of the right input. Or give me numbers XOXO.", preferredStyle: UIAlertController.Style.alert)
            let cancelAction2=UIAlertAction(title: "Hugs and Kisses", style:UIAlertAction.Style.cancel, handler: nil)
            alert2.addAction(cancelAction2)
            rightInput = 0.0
            
            present(alert2, animated: true, completion: nil)
        } else{
            rightInput = Float(rightText.text!)!
        }
        displayResult = leftInput + rightInput
        result.text = String(displayResult)
    }
    
    // Call math function after input end
    func textFieldDidEndEditing(_ textField: UITextField) {
        updateResult()
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Cratimg deligates
        leftText.delegate = self
        rightText.delegate = self
        
        // Lets not do this becouse it make some of my messages obsilite.
        //leftText.keyboardType = .numberPad
        //rightText.keyboardType = .numberPad
    }
}
