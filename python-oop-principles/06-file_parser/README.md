Heuristic File Type Detector: Byte-Frequency Analysis
📝 Description

This Python application implements a robust file type detection engine that identifies file formats based on their internal byte distribution rather than unreliable file extensions. By calculating the frequency of characters (0–255) and analyzing specific structural patterns, the tool can accurately distinguish between plain text, various encodings, binary data, and specific structured formats like XML and BMP.

The project highlights advanced OOP principles, specifically inheritance and polymorphism, to create a scalable architecture for file classification.
🚀 Key Features

    Frequency-Based Detection: Uses statistical analysis of byte occurrences to differentiate between ASCII, UTF-16, and Binary files.

    Encoding Identification:

        UTF-8/ASCII: High frequency of printable characters (ASCII 32–127).

        UTF-16: Detects null-byte padding (typically >30% of the content).

    Deep Inspection:

        XML: Specialized parsing for ASCII files to identify markup tags.

        BMP: Binary header inspection to extract metadata such as width, height, and Bits-Per-Pixel (BPP).

    Recursive Scanning: Automatically crawls through directory trees to process batches of files.

🏗️ Project Structure
Plaintext

FileTypeDetector/
├── main.py            # Main execution script and directory crawler
├── filetype.py        # Core OOP hierarchy (GenericFile and subclasses)
├── filesToParse/      # Test dataset directory
└── README.md

🛠️ Detection Logic & Heuristics

The application classifies files by evaluating the frequency array freq and the mean occurrence mean:

    ASCII/UTF-8: If non-printable "control" characters occur with negligible frequency.

    UTF-16: If the null character (byte 0) represents a significant portion of the file (threshold ≥30%).

    Binary: If the distribution across the 0–255 range is relatively uniform.

    BMP: A binary file where the header contains specific dimensions and depth metadata.

💻 Usage Example

To scan the default filesToParse directory:
Bash

python main.py

Typical Output:
Plaintext

File: utf16.txt | Type: TextUNICODE (UTF-16)
File: sample.bmp | Type: BMP Image (1280x853, 24 bpp)
File: data.xml   | Type: XMLFile (First Tag: <root>)
File: app.bin    | Type: Binary Data

⚙️ Setup

    Clone the repository:
    Bash

    git clone https://github.com/YourUsername/Paradigms-of-Programming-Alin.git

    Navigate to the project:
    Bash

    cd python-oop-principles/FileTypeDetector

    Run the detector:
    Bash

    python main.py
