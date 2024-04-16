import React from 'react';
import { Text, View } from 'react-native';

const RNSampleComponent: React.FC = () => {
    return (
        <View style={{
            flex: 1,
            justifyContent: 'center',
            alignItems: 'center'
        }}>
            <Text>React Native Component rendered inside native Android!</Text>
        </View>
    )
}
export default RNSampleComponent;