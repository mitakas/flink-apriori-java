# flink-apriori-java
Apriori Algorithm in Apache Flink

## Algorithm
This project implements the Apriori algorithm as described in the 1994 paper
"[Fast Algorithms for Mining Association Rules](http://www.vldb.org/conf/1994/P487.PDF)" by 
Rakesh Agrawal and Ramakrishnan Srikant.

### Paper

AGRAWAL, Rakesh, et al. **Fast Algorithms for Mining Association Rules**. In: Proc. 20th Int. Conf.
Very Large Data Bases, VLDB. 1994. S. 487-499.

## Project

Build the jar file using the following command: 

`mvn clean package -Pbuild-jar`

This should produce a file called `flink-apriori-java-1.0-SNAPSHOT.jar` in the `target` directory.

### Parameters

* `input` location of the BMS-POS.dat file
* `output` prints to stdout if not set
* `min-support` a real number in the range (0,1]
* `itemset-size` an integer in the range (1, Infinity]

### Dependencies

* [Google Guava](https://github.com/google/guava) 19.0 (Apache License 2.0)
* [Apache Commons Lang](https://commons.apache.org/proper/commons-lang/) 3.4 (Apache License 2.0)

## Data
Download the [KDD Cup 2000 Dataset](http://www.kdd.org/cupfiles/KDDCup2000.zip).
More info about the data [here](http://www.kdd.org/kdd-cup/view/kdd-cup-200).

### Preparation

After downloading the data, unpack the BMS-POS.dat file. Included in this repository is a
[checksum file](BMS-POS.dat.sha1) for verifying the integrity of the file.

Steps:

1. `unzip -j KDDCup2000.zip assoc/BMS-POS.dat.gz`
2. `gunzip BMS-POS.dat.gz`
3. `sha1sum -c BMS-POS.dat.sha1`

## License
Apache License 2.0

This project uses libraries licensed under Apache License 2.0
