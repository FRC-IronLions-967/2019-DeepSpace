#### Windows, linux, RoboRio

[![Build Status](https://dev.azure.com/matthewbehnke0/matthewbehnke0/_apis/build/status/FRC-IronLions-967.2019-DeepSpace?branchName=master&jobName=windows)](https://dev.azure.com/matthewbehnke0/matthewbehnke0/_build/latest?definitionId=1?branchName=master) [![Build Status](https://dev.azure.com/matthewbehnke0/matthewbehnke0/_apis/build/status/FRC-IronLions-967.2019-DeepSpace?branchName=master&jobName=linux)](https://dev.azure.com/matthewbehnke0/matthewbehnke0/_build/latest?definitionId=1?branchName=master) [![Build Status](https://dev.azure.com/matthewbehnke0/matthewbehnke0/_apis/build/status/FRC-IronLions-967.2019-DeepSpace?branchName=master&jobName=roborio)](https://dev.azure.com/matthewbehnke0/matthewbehnke0/_build/latest?definitionId=1?branchName=master)

# Iron Lions 2019 Codebase

### How to deploy to the robot 

Go over to the releases tab and download the latest release. Once the file is downloaded unzip the folder. Next open the folder and type ```cmd``` into the folder path to open a command prompt in the projects directory. then while still connected to the internet type ```./gradlew build```. After the build finishes and gradle downloads all of the required files connect to the robot and type ```./gradlew deploy```. 