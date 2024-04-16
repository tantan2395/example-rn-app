import React from 'react';
import {
  SafeAreaView,
  StyleSheet,
  Text,
  TouchableOpacity,
  View,
  NativeModules,
  AppRegistry,
} from 'react-native';

import RNSampleComponent from './src/RNSampleComponent';

const ToastService = NativeModules.ToastModule;
const FragmentService = NativeModules.FragmentModule;

function App(): React.JSX.Element {
  const newFragment = FragmentService.showFragment();

  return (
    <SafeAreaView style={styles.container}>
      { newFragment }
      <Text>
        Text from React Native
      </Text>
      <TouchableOpacity onPress={() => ToastService.showToast("You are toasted!")}>
        <View style={styles.btn}>
          <Text>
            Click here to display toast
          </Text>
        </View>
      </TouchableOpacity>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center'
  },
  btn: {
    padding: 10,
    backgroundColor: 'cyan'
  }
});

export default App;

AppRegistry.registerComponent('RNSampleComponent', () => RNSampleComponent)
