package UI;

import UI.constant.PropertiesLocale;
import UI.constant.UIConstants;
import UI.panel.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MainWindow {

    public static JFrame frame;

    public static JPanel mainPanel;
    public static JPanel centerPanel;
    public static MessagePanel messagePanel;
    public static SettingPanel settingPanel;
    public static PicturePanel picturePanel;
    public static SignaturePanel signaturePanel;

    /**
     * 构造方法
     * created in 0:38 2018/4/30
     */
    private MainWindow(){
        initialize();
    }

    /**
     * 初始化
     * created in 0:39 2018/4/30
     */
    private void initialize(){
        //加载配置文件
        PropertiesLocale.initialize();

        // 设置系统默认样式
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // 初始化主窗口
        frame = new JFrame();
        frame.setBounds(UIConstants.MAIN_WINDOW_X, UIConstants.MAIN_WINDOW_Y, UIConstants.MAIN_WINDOW_WIDTH,
                UIConstants.MAIN_WINDOW_HEIGHT);
        frame.setTitle(UIConstants.APP_NAME + "  -  " + UIConstants.APP_VERSION);
        frame.setIconImage(UIConstants.IMAGE_ICON);
        frame.setBackground(UIConstants.MAIN_BACK_COLOR);
        mainPanel = new JPanel(true);
        mainPanel.setBackground(Color.white);
        mainPanel.setLayout(new BorderLayout());

        NaviBarPanel naviBar = new NaviBarPanel();
        messagePanel = new MessagePanel();
        picturePanel = new PicturePanel();
        settingPanel = new SettingPanel();
        signaturePanel = new SignaturePanel();

        mainPanel.add(naviBar, BorderLayout.WEST);

        centerPanel = new JPanel(true);
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(messagePanel, BorderLayout.CENTER);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        frame.add(mainPanel);

        frame.addWindowListener(new WindowListener() {

            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosed(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowActivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }
        });
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void freshLocale(){
        NaviBarPanel.refreshLocale();
        settingPanel.refreshLocale();
        messagePanel.refreshLocale();
        picturePanel.refreshLocale();
        signaturePanel.refreshLocale();
        //TODO

    }


    /**
     * 主方法，程序入口
     * created in 0:35 2018/4/30
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MainWindow window = new MainWindow();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
