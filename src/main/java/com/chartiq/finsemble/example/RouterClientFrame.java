package com.chartiq.finsemble.example;

import com.chartiq.finsemble.Finsemble;
import com.chartiq.finsemble.interfaces.CallbackListener;
import com.chartiq.finsemble.model.PubSubModel;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.util.Objects;

public class RouterClientFrame {
    private JPanel mainPanel;
    private JButton addPubSubResponderButton;
    private JButton removePubSubResponderButton;
    private JButton addResponderButton;
    private JButton onReadyButton;
    private JButton trustedMessageButton;
    private JButton disconnectAllButton;
    private JTextField textAddPubSubTopic;
    private JCheckBox addIsRegEx;
    private JTextField textChannel;
    private JTextArea textTrustedMessage;
    private JTextField textRemovePubSubTopic;
    private JCheckBox removeIsRegEx;
    private JTextArea textLogs;
    private JButton clearButton;
    private JButton publish;
    private JTextField textTopicPublish;

    private final CallbackListener defaultCallback = ((err, res) -> {
        if (Objects.nonNull(err)) {
            writeLogs(err.toString(4));
        } else {
            writeLogs(res.toString(4));
        }
    });

    private void writeLogs(String text) {
        textLogs.append("\n" + text);
    }

    public RouterClientFrame(Finsemble fsbl) {

        clearButton.addActionListener(e -> textLogs.setText(""));
        onReadyButton.addActionListener(e -> fsbl.getClients().getRouterClient().onReady(defaultCallback));
        disconnectAllButton.addActionListener(e -> fsbl.getClients().getRouterClient().disconnectAll());
        publish.addActionListener(e -> fsbl.getClients().getRouterClient().publish(textTopicPublish.getText(), new JSONObject() {{
            put("dataType", "symbol");
            put("data", "lalalal");
        }}));

        addPubSubResponderButton.addActionListener(e ->
                fsbl.getClients().getRouterClient().addPubSubResponder(
                        textAddPubSubTopic.getText(),
                        addIsRegEx.isSelected(),
                        new JSONObject(),
                        new PubSubModel(defaultCallback, defaultCallback, defaultCallback), defaultCallback)
        );

        removePubSubResponderButton.addActionListener(e ->
                fsbl.getClients().getRouterClient().removePubSubResponder(textAddPubSubTopic.getText(), addIsRegEx.isSelected(), defaultCallback)
        );

        addResponderButton.addActionListener(e ->
                fsbl.getClients().getRouterClient().addResponder(textChannel.getText(), defaultCallback)
        );

        trustedMessageButton.addActionListener(e -> defaultCallback.callback(null,
                new JSONObject() {{
                    put("result", fsbl.getClients().getRouterClient().trustedMessage(new JSONObject(textTrustedMessage.getText())));
                }})
        );

        DefaultCaret caret = new DefaultCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        textLogs.setCaret(caret);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new FormLayout("left:4dlu:noGrow,fill:max(d;4px):noGrow,fill:171px:noGrow,fill:max(d;4px):noGrow,left:72dlu:noGrow,fill:307px:noGrow", "center:max(d;4px):noGrow,top:4dlu:noGrow,center:d:noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:32px:noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:34px:noGrow,center:30px:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,top:146dlu:noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow"));
        mainPanel.setMinimumSize(new Dimension(640, 550));
        mainPanel.setPreferredSize(new Dimension(640, 550));
        addPubSubResponderButton = new JButton();
        addPubSubResponderButton.setText("addPubSubResponder");
        CellConstraints cc = new CellConstraints();
        mainPanel.add(addPubSubResponderButton, cc.xy(3, 3));
        removePubSubResponderButton = new JButton();
        removePubSubResponderButton.setText("removePubSubResponder");
        mainPanel.add(removePubSubResponderButton, cc.xy(3, 5));
        addResponderButton = new JButton();
        addResponderButton.setText("addResponder");
        mainPanel.add(addResponderButton, cc.xy(3, 7));
        addIsRegEx = new JCheckBox();
        addIsRegEx.setText("isRegEx");
        mainPanel.add(addIsRegEx, cc.xy(6, 3));
        removeIsRegEx = new JCheckBox();
        removeIsRegEx.setText("isRegEx");
        mainPanel.add(removeIsRegEx, cc.xy(6, 5));
        textAddPubSubTopic = new JTextField();
        textAddPubSubTopic.setText("topic");
        mainPanel.add(textAddPubSubTopic, cc.xy(5, 3, CellConstraints.FILL, CellConstraints.DEFAULT));
        textRemovePubSubTopic = new JTextField();
        textRemovePubSubTopic.setText("topic");
        mainPanel.add(textRemovePubSubTopic, cc.xy(5, 5, CellConstraints.FILL, CellConstraints.DEFAULT));
        textChannel = new JTextField();
        textChannel.setText("channel");
        mainPanel.add(textChannel, cc.xy(5, 7, CellConstraints.FILL, CellConstraints.DEFAULT));
        clearButton = new JButton();
        clearButton.setText("Clear");
        mainPanel.add(clearButton, cc.xy(6, 19, CellConstraints.RIGHT, CellConstraints.DEFAULT));
        final JScrollPane scrollPane1 = new JScrollPane();
        mainPanel.add(scrollPane1, cc.xyw(3, 17, 4, CellConstraints.FILL, CellConstraints.FILL));
        textLogs = new JTextArea();
        scrollPane1.setViewportView(textLogs);
        trustedMessageButton = new JButton();
        trustedMessageButton.setText("trustedMessage");
        mainPanel.add(trustedMessageButton, cc.xy(3, 11));
        onReadyButton = new JButton();
        onReadyButton.setText("onReady");
        mainPanel.add(onReadyButton, cc.xy(3, 13));
        disconnectAllButton = new JButton();
        disconnectAllButton.setText("disconnectAll");
        mainPanel.add(disconnectAllButton, cc.xy(3, 15));
        final JScrollPane scrollPane2 = new JScrollPane();
        mainPanel.add(scrollPane2, cc.xywh(5, 11, 2, 2, CellConstraints.FILL, CellConstraints.FILL));
        textTrustedMessage = new JTextArea();
        textTrustedMessage.setTabSize(8);
        textTrustedMessage.setText("{}");
        scrollPane2.setViewportView(textTrustedMessage);
        publish = new JButton();
        publish.setText("publish");
        mainPanel.add(publish, cc.xy(3, 9, CellConstraints.FILL, CellConstraints.DEFAULT));
        textTopicPublish = new JTextField();
        textTopicPublish.setText("topic");
        mainPanel.add(textTopicPublish, cc.xy(5, 9, CellConstraints.FILL, CellConstraints.DEFAULT));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
