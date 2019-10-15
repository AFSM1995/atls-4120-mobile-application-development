//
//  ViewController.swift
//  Midterm
//
//  Created by Álvaro Santillan on 10/15/19.
//  Copyright © 2019 Álvaro Santillan. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    @IBOutlet weak var cummuteMilesUser: UITextField!
    @IBOutlet weak var gasTankUser: UISlider!
    @IBOutlet weak var totalCommuteTimeLabel: UILabel!
    @IBOutlet weak var GasToPurchaseLabel: UILabel!
    @IBOutlet weak var gasInTank: UILabel!
    @IBOutlet weak var segController: UISegmentedControl!
    @IBOutlet weak var image: UIImageView!
    @IBOutlet weak var switchMonth: UISwitch!
    @IBOutlet weak var cummuteCalculate: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    // Hide keyboard when the user press return
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    // Check if value in numerical
    // Return false if no numeric confirmed
    func isNumeric(testSubject: String) -> Bool {
        return Double(testSubject) != nil
    }
    
    func calculation() {
        
        var commuteMiles: Float
        
        // Check if illigal value
        var tripCheck = isNumeric(testSubject: cummuteMilesUser.text!)
        
        // Check if illigal value
        if tripCheck == false{
            print("consile left Na Fam")
            
            // Display message
            let alert=UIAlertController(title: "Naa Fam", message: "Take your letters and fancy algebra out of the left input. Or give me numbers XOXO.", preferredStyle: UIAlertController.Style.alert)
            let cancelAction=UIAlertAction(title: "Got it fam", style:UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancelAction)
            present(alert, animated: true, completion: nil)
            // End Display message
            
            // update text feild
            commuteMiles = 0.0
        } else{
            commuteMiles = Float(cummuteMilesUser.text!)!
        }
        
        if segController.selectedSegmentIndex == 0 {
            let avgCarSpeed: Float = 20
            let avgCarFuelEco: Float = 24
            let totalCommuteResult: Float
            let gasToPearchase: Float
            var gasInUser: Float = gasTankUser.value
            
            
            
            image.image = UIImage(named: "car_icon")
            
            if switchMonth.isOn {
                totalCommuteTimeLabel.text = String(format: "%.0f", (commuteMiles/avgCarSpeed)*20) + " hours"
                GasToPurchaseLabel.text = String(format: "%.0f", (commuteMiles/avgCarFuelEco)*20) + " gallons"
            } else {
                totalCommuteTimeLabel.text = String(format: "%.0f", (commuteMiles/avgCarSpeed)) + " hours"
                GasToPurchaseLabel.text = String(format: "%.0f", (commuteMiles/avgCarFuelEco)) + " gallons"
            }
            
            totalCommuteTimeLabel.text = String(format: "%.0f", (commuteMiles/avgCarSpeed)) + " hours"
            GasToPurchaseLabel.text = String(format: "%.0f", (commuteMiles/avgCarFuelEco)) + " gallons"
        }
        if segController.selectedSegmentIndex == 2 {
            let bikeAVGSpeed: Float = 10
            image.image = UIImage(named: "bike_icon")
            
            totalCommuteTimeLabel.text = String(format: "%.0f", (commuteMiles/bikeAVGSpeed)) + " hours"
            GasToPurchaseLabel.text = String(format: "%.0f", 0.0) + " gallons"
            
            if switchMonth.isOn {
                totalCommuteTimeLabel.text = String(format: "%.0f", (commuteMiles/bikeAVGSpeed)*20) + " hours"
                GasToPurchaseLabel.text = String(format: "%.0f", 0.0) + " gallons"
            } else {
                totalCommuteTimeLabel.text = String(format: "%.0f", (commuteMiles/bikeAVGSpeed)) + " hours"
                GasToPurchaseLabel.text = String(format: "%.0f", 0.0) + " gallons"
            }
        }
        if segController.selectedSegmentIndex == 1 {
            let busAVGSpeed: Float = 12
            image.image = UIImage(named: "bus_icon")
            
            totalCommuteTimeLabel.text = String(format: "%.0f", (commuteMiles/busAVGSpeed)) + " hours"
            GasToPurchaseLabel.text = String(format: "%.0f", 0.0) + " gallons"
            
            if switchMonth.isOn {
                totalCommuteTimeLabel.text = String(format: "%.0f", (commuteMiles/busAVGSpeed)*20) + " hours"
                GasToPurchaseLabel.text = String(format: "%.0f", 0.0) + " gallons"
            } else {
                totalCommuteTimeLabel.text = String(format: "%.0f", (commuteMiles/busAVGSpeed) + 10) + " hours"
                GasToPurchaseLabel.text = String(format: "%.0f", 0.0) + " gallons"
            }
        }
    }
    
    @IBAction func buttonpressed(_ sender: UIButton) {
        calculation()
    }
    
    // Call math function after input end
    func textFieldDidEndEditing(_ textField: UITextField) {
        //calculation()
    }
    
    // Hide keyboard when user touches outside keyboard.
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
        cummuteMilesUser.delegate = self
    }

    @IBAction func monthView(_ sender: UISwitch) {
        calculation()
    }
    
    @IBAction func segViewAction(_ sender: UISegmentedControl) {
        calculation()
    }
    
    @IBAction func slider(_ sender: UISlider) {
        //gasInTank.text = "Gas in tank" + String(self.value)
        let fontSize = sender.value
        let fontSizeCGFloat=CGFloat(fontSize)
        gasInTank.text=String(format: "Gas in tank " + "%.0f", fontSize)
    }
}

