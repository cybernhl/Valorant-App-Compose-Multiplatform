import SwiftUI
import common

@main
struct iOSApp: App {
    init() {
        ModulesKt.doInitKoin()
    }
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
