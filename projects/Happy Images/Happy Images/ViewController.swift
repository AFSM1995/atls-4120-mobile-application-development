//
//  ViewController.swift
//  Happy Images
//
//  Created by Álvaro Santillan on 10/5/19.
//  Copyright © 2019 Álvaro Santillan. All rights reserved.
//

import UIKit
import AVFoundation

class ViewController: UIViewController {
    
    var player: AVAudioPlayer?
    let soundArray = ["note1","note2","note3","note4","note5","note6","note7"]

    @IBOutlet weak var imageView1: UIImageView!
    @IBOutlet weak var imageView2: UIImageView!
    @IBOutlet weak var imageView3: UIImageView!
    @IBOutlet weak var imageView4: UIImageView!
    @IBOutlet weak var imageView5: UIImageView!
    @IBOutlet weak var segControl: UISegmentedControl!
    @IBOutlet weak var segControlBottom: UISegmentedControl!
    
    override func viewDidLoad() {
        let alMeme = ["viewDL1","viewDL1","viewDL1","viewDL1","viewDL1"]
        let appleArray = ["t1","t2","t3","t4","t5"]
        var display = alMeme
        let randomNumber = Int.random(in: 0 ... 1)
        
        if randomNumber == 1 {
            display = appleArray
        }
        
        super.viewDidLoad()
        imageView1.image = UIImage(named: display[0])
        imageView2.image = UIImage(named: display[1])
        imageView3.image = UIImage(named: display[2])
        imageView4.image = UIImage(named: display[3])
        imageView5.image = UIImage(named: display[4])
        // Do any additional setup after loading the view.
    }
    @IBAction func topSwitcher(_ sender: Any) {
        if segControl.selectedSegmentIndex == 0 {
            segControlBottom.selectedSegmentIndex = 0
            imageView1.image = UIImage(named: "p" + String(Int.random(in: 1 ... 20)))
            imageView2.image = UIImage(named: "p" + String(Int.random(in: 1 ... 20)))
            imageView3.image = UIImage(named: "p" + String(Int.random(in: 1 ... 20)))
            imageView4.image = UIImage(named: "p" + String(Int.random(in: 1 ... 20)))
            imageView5.image = UIImage(named: "p" + String(Int.random(in: 1 ... 20)))
        } else if segControl.selectedSegmentIndex == 1 {
            segControlBottom.selectedSegmentIndex = 1
            imageView1.image = UIImage(named: "m" + String(Int.random(in: 1 ... 20)))
            imageView2.image = UIImage(named: "m" + String(Int.random(in: 1 ... 20)))
            imageView3.image = UIImage(named: "m" + String(Int.random(in: 1 ... 20)))
            imageView4.image = UIImage(named: "m" + String(Int.random(in: 1 ... 20)))
            imageView5.image = UIImage(named: "m" + String(Int.random(in: 1 ... 20)))
        } else if segControl.selectedSegmentIndex == 2 {
            segControlBottom.selectedSegmentIndex = 2
            imageView1.image = UIImage(named: "c" + String(Int.random(in: 1 ... 20)))
            imageView2.image = UIImage(named: "c" + String(Int.random(in: 1 ... 20)))
            imageView3.image = UIImage(named: "c" + String(Int.random(in: 1 ... 20)))
            imageView4.image = UIImage(named: "c" + String(Int.random(in: 1 ... 20)))
            imageView5.image = UIImage(named: "c" + String(Int.random(in: 1 ... 20)))
        } else if segControl.selectedSegmentIndex == 3 {
            segControlBottom.selectedSegmentIndex = 3
            imageView1.image = UIImage(named: "a" + String(Int.random(in: 1 ... 20)))
            imageView2.image = UIImage(named: "a" + String(Int.random(in: 1 ... 20)))
            imageView3.image = UIImage(named: "a" + String(Int.random(in: 1 ... 20)))
            imageView4.image = UIImage(named: "a" + String(Int.random(in: 1 ... 20)))
            imageView5.image = UIImage(named: "a" + String(Int.random(in: 1 ... 20)))
        } else if segControl.selectedSegmentIndex == 4 {
            segControlBottom.selectedSegmentIndex = 4
            imageView1.image = UIImage(named: "s" + String(Int.random(in: 1 ... 20)))
            imageView2.image = UIImage(named: "s" + String(Int.random(in: 1 ... 20)))
            imageView3.image = UIImage(named: "s" + String(Int.random(in: 1 ... 20)))
            imageView4.image = UIImage(named: "s" + String(Int.random(in: 1 ... 20)))
            imageView5.image = UIImage(named: "s" + String(Int.random(in: 1 ... 20)))
        } else {
            // Print error message
        }
    }
    
    @IBAction func bottomSwitch(_ sender: Any) {
        if segControlBottom.selectedSegmentIndex == 0 {
            segControl.selectedSegmentIndex = 0
            imageView1.image = UIImage(named: "p" + String(Int.random(in: 1 ... 20)))
            imageView2.image = UIImage(named: "p" + String(Int.random(in: 1 ... 20)))
            imageView3.image = UIImage(named: "p" + String(Int.random(in: 1 ... 20)))
            imageView4.image = UIImage(named: "p" + String(Int.random(in: 1 ... 20)))
            imageView5.image = UIImage(named: "p" + String(Int.random(in: 1 ... 20)))
        } else if segControlBottom.selectedSegmentIndex == 1 {
            segControl.selectedSegmentIndex = 1
            imageView1.image = UIImage(named: "m" + String(Int.random(in: 1 ... 20)))
            imageView2.image = UIImage(named: "m" + String(Int.random(in: 1 ... 20)))
            imageView3.image = UIImage(named: "m" + String(Int.random(in: 1 ... 20)))
            imageView4.image = UIImage(named: "m" + String(Int.random(in: 1 ... 20)))
            imageView5.image = UIImage(named: "m" + String(Int.random(in: 1 ... 20)))
        } else if segControlBottom.selectedSegmentIndex == 2 {
            segControl.selectedSegmentIndex = 2
            imageView1.image = UIImage(named: "c" + String(Int.random(in: 1 ... 20)))
            imageView2.image = UIImage(named: "c" + String(Int.random(in: 1 ... 20)))
            imageView3.image = UIImage(named: "c" + String(Int.random(in: 1 ... 20)))
            imageView4.image = UIImage(named: "c" + String(Int.random(in: 1 ... 20)))
            imageView5.image = UIImage(named: "c" + String(Int.random(in: 1 ... 20)))
        } else if segControlBottom.selectedSegmentIndex == 3 {
            segControl.selectedSegmentIndex = 3
            imageView1.image = UIImage(named: "a" + String(Int.random(in: 1 ... 20)))
            imageView2.image = UIImage(named: "a" + String(Int.random(in: 1 ... 20)))
            imageView3.image = UIImage(named: "a" + String(Int.random(in: 1 ... 20)))
            imageView4.image = UIImage(named: "a" + String(Int.random(in: 1 ... 20)))
            imageView5.image = UIImage(named: "a" + String(Int.random(in: 1 ... 20)))
        } else if segControlBottom.selectedSegmentIndex == 4 {
            segControl.selectedSegmentIndex = 4
            imageView1.image = UIImage(named: "s" + String(Int.random(in: 1 ... 20)))
            imageView2.image = UIImage(named: "s" + String(Int.random(in: 1 ... 20)))
            imageView3.image = UIImage(named: "s" + String(Int.random(in: 1 ... 20)))
            imageView4.image = UIImage(named: "s" + String(Int.random(in: 1 ... 20)))
            imageView5.image = UIImage(named: "s" + String(Int.random(in: 1 ... 20)))
        } else {
            // Print error message
        }
    }
    
    func buttonClicker(button: String) -> String {
        var outputString = "-"
        var section = "-"
        
        if segControlBottom.selectedSegmentIndex == 0 {
            section = "p"
        } else if segControlBottom.selectedSegmentIndex == 1 {
            section = "p"
        } else if segControlBottom.selectedSegmentIndex == 2 {
            section = "p"
        } else if segControlBottom.selectedSegmentIndex == 3 {
            section = "p"
        } else if segControlBottom.selectedSegmentIndex == 4 {
            section = "p"
        } else {
            // print error
        }
        
        if button == "imgButton1" {
            outputString = "p" + String(Int.random(in: 1 ... 20))
        } else if button == "imgButton2" {
            outputString = "m" + String(Int.random(in: 1 ... 20))
        } else if button == "imgButton3" {
            outputString = "c" + String(Int.random(in: 1 ... 20))
        } else if button == "imgButton4" {
            outputString = "a" + String(Int.random(in: 1 ... 20))
        } else if button == "imgButton5" {
            outputString = "s" + String(Int.random(in: 1 ... 20))
        } else {
            // print error
        }
        return outputString
    }
    
    @IBAction func imgView1Button(_ sender: Any) {
        imageView1.image = UIImage(named: buttonClicker(button: "imgButton1"))
    }
    
    @IBAction func imgView2Button(_ sender: Any) {
        imageView1.image = UIImage(named: buttonClicker(button: "imgButton2"))
    }
    
    @IBAction func imgViewButton3(_ sender: Any) {
        imageView1.image = UIImage(named: buttonClicker(button: "imgButton3"))
    }
    
    @IBAction func imgView4Button(_ sender: Any) {
        imageView1.image = UIImage(named: buttonClicker(button: "imgButton4"))
    }
    
    @IBAction func imgView5Button(_ sender: Any) {
        imageView1.image = UIImage(named: buttonClicker(button: "imgButton5"))
    }
    
    @IBAction func soundButton(_ sender: Any) {
        playSound(selectedSoundFileName: soundArray[1])
    }
    
    // CHANGE ALL OF ME
    func playSound(selectedSoundFileName: String) {
        let path = Bundle.main.path(forResource: selectedSoundFileName, ofType:"wav")!
        let url = URL(fileURLWithPath: path)
        
        do {
            // Open cd player put in disk
            let sound = try AVAudioPlayer(contentsOf: url)
            self.player = sound
            //sound.numberOfLoops = 0
            //sound.prepareToPlay()
            sound.play()
        } catch {
            print("error loading file")
            // couldn't load file :(
        }
    }
}

