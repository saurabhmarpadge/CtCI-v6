#include <bits/stdc++.h>
using namespace std;

bool with_DS(const string &s){
  vector<int> v(128);
  for(int i=0;i<s.length();i++){
    if(v[s[i]]){
      return false;
    }
    v[s[i]]++;
  }
  return true;
}

bool without_DS(const string &s){
  for(int i=0;i<s.length();i++){
    for(int j=i+1;j<s.length();j++){
      if(s[i] == s[j]){
        return false;
      }
    }
  }
  return true;
}

int main(){
string s;
cin>>s;
if(with_DS(s)){
  cout<<"Unique"<<endl;
} else {
  cout<<"Not Unique"<<endl;
}
if(without_DS(s)){
  cout<<"Unique"<<endl;
} else {
  cout<<"Not Unique"<<endl;
}


return 0;
}
