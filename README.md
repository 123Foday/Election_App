# VotePlus

A modern Android application for digital voting and election management. VotePlus provides a secure and user-friendly platform for voter registration, candidate information, and electronic voting.

## 📱 Features

### Core Functionality
- **Voter Registration**: Complete voter registration with personal information
- **Candidate Management**: View candidate profiles, manifestos, and experience
- **Electronic Voting**: Secure voting interface with confirmation
- **Status Tracking**: Real-time voter status and voting progress

### User Experience
- **Modern UI**: Clean, intuitive interface with Material Design
- **Status Indicators**: Visual feedback for registration and voting status
- **Responsive Design**: Optimized for various screen sizes
- **Edge-to-Edge**: Modern Android edge-to-edge display

## 🏗️ Architecture

### Project Structure
```
app/src/main/java/com/group10/vote/
├── activities/
│   ├── MainActivity.kt
│   ├── VoterRegistrationActivity.kt
│   ├── CandidateListActivity.kt
│   ├── CandidateDetailActivity.kt
│   └── VotingActivity.kt
├── models/
│   ├── User.kt
│   ├── Candidate.kt
│   └── Vote.kt
└── adapters/
    └── (RecyclerView adapters)
```

### Data Models
- **User**: Voter information and registration status
- **Candidate**: Political candidate profiles and details
- **Vote**: Voting records and timestamps

## 🚀 Getting Started

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK 24+ (API Level 24)
- Java 11 or higher
- Kotlin 1.8+

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/VotePlus.git
   cd VotePlus
   ```

2. **Open in Android Studio**
   - Launch Android Studio
   - Select "Open an existing Android Studio project"
   - Navigate to the VotePlus directory and open it

3. **Sync and Build**
   - Wait for Gradle sync to complete
   - Build the project (Build → Make Project)

4. **Run the Application**
   - Connect an Android device or start an emulator
   - Click the "Run" button (green play icon)
   - Select your target device and install the app

## 📋 Usage

### Voter Registration
1. Launch the app
2. Tap "Register as Voter"
3. Fill in your personal information:
   - Full Name
   - Email Address
   - Phone Number
   - Date of Birth
   - Address
   - National ID
4. Submit the registration form

### Viewing Candidates
1. From the main screen, tap "View Candidates"
2. Browse through the list of candidates
3. Tap on a candidate to view detailed information:
   - Personal details
   - Party affiliation
   - Position running for
   - Experience and education
   - Campaign manifesto

### Casting Your Vote
1. Ensure you're registered as a voter
2. Navigate to the voting section
3. Select your preferred candidate
4. Confirm your vote
5. View voting confirmation

## 🛠️ Technical Details

### Dependencies
- **AndroidX Core KTX**: Kotlin extensions for Android
- **AppCompat**: Backward compatibility
- **Material Design**: UI components
- **RecyclerView**: List display
- **CardView**: Card-based layouts
- **ConstraintLayout**: Flexible layouts

### Key Components
- **Activities**: Main navigation and user interface
- **SharedPreferences**: Local data storage for user state
- **RecyclerView**: Efficient list display for candidates
- **Intent Navigation**: Activity transitions

### Data Storage
- User registration status
- Voting history
- Candidate information
- Application preferences

## 📱 Screenshots

*[Screenshots would be added here showing the main interface, registration form, candidate list, and voting screen]*

## 🔧 Configuration

### Build Configuration
- **Minimum SDK**: 24 (Android 7.0)
- **Target SDK**: 35 (Android 15)
- **Compile SDK**: 35
- **Version**: 1.0

### Permissions
The app uses standard Android permissions for:
- Internet access (if backend integration is added)
- Storage access (for data persistence)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Team

- **Group 10**: Development team
- **Course**: Android Development
- **Institution**: [Your Institution]

## 🐛 Known Issues

- Currently uses local storage only
- No backend integration
- Limited to single-device voting

## 🔮 Future Enhancements

- [ ] Backend integration for real-time results
- [ ] Multi-language support
- [ ] Biometric authentication
- [ ] Real-time vote counting
- [ ] Admin panel for election management
- [ ] Push notifications for election updates

## 📞 Support

For support and questions:
- Create an issue in the GitHub repository
- Contact the development team
- Check the documentation

---

**VotePlus** - Making democracy accessible through technology. 