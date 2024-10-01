import UIKit
import common

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
    override init(){
       ModulesKt.doInitKoin()
    }

    var window: UIWindow?

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        window = UIWindow(frame: UIScreen.main.bounds)
        let mainViewController = MainViewControllerKt.MainViewController()
        window?.rootViewController = mainViewController
        window?.makeKeyAndVisible()
        return true
    }
}
