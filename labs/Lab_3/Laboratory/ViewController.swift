//
//  ViewController.swift
//  Laboratory
//
//  Created by Álvaro Santillan on 9/23/19.
//  Copyright © 2019 Álvaro Santillan. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var segController: UISegmentedControl!
    @IBOutlet weak var imageView: UIImageView!
    @IBOutlet weak var textFeild: UILabel!
    @IBOutlet weak var changeLabelButton: UISwitch!
    @IBOutlet weak var changeCaseButton: UISwitch!
    @IBOutlet weak var changeFontSize: UILabel!
    
    // Change picture
    func changePicture(){
        if segController.selectedSegmentIndex == 0 {
            imageView.image=UIImage(named: "1")
        }
        else if segController.selectedSegmentIndex == 1 {
            imageView.image=UIImage(named: "2")
        }
    }
    
    // Change text and color
    func changeLabel(){
        if changeLabelButton.isOn {
            textFeild.text = "Wow what a pritty image."
            textFeild.textColor = UIColor.red
        } else {
            textFeild.text = "This is a nice picture."
            textFeild.textColor = UIColor.blue
        }
    }
    
    // Change text case
    func changeCase(){
        if changeCaseButton.isOn {
            textFeild.text=textFeild.text?.lowercased()
        } else {
            textFeild.text=textFeild.text?.uppercased()
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    // Actions that call functions.
    @IBAction func textChangeButton(_ sender: Any) {
        changeLabel()
    }
    
    @IBAction func capChangeButton(_ sender: Any) {
        changeCase()
    }
    
    @IBAction func ImageChange(_ sender: UISegmentedControl) {
        changePicture()
    }
    
    // Change font size with slider
    @IBAction func fontSizeSlider(_ sender: UISlider) {
        let fontSize = sender.value
        let fontSizeCGFloat=CGFloat(fontSize)
        textFeild.font=UIFont.systemFont(ofSize: fontSizeCGFloat)
    }
}
