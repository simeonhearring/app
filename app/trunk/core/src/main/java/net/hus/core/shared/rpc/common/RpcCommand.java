package net.hus.core.shared.rpc.common;

import java.io.Serializable;

public interface RpcCommand extends Serializable
{
  void setUserInfo(String inUser);

  String getUserInfo();

  void setIpAddress(String inIp);

  String getIpAddress();

  void setEncryptKey(String inEncryptKey);

  boolean isEncryptRequired();

  boolean isEncrypted();

  void encrypt();

  void decrypt();
}